package com.comp.cloudtech.service.impl;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comp.cloudtech.UserAccount;
import com.comp.cloudtech.db.repository.UserAccountRepository;
import com.comp.cloudtech.service.DevIssueBookService;
import static java.util.Objects.nonNull;

@Service
@Transactional
public class DevIssueBookServiceImpl implements DevIssueBookService {

	Logger log = LoggerFactory.getLogger(DevIssueBookServiceImpl.class);
	
	final static String FILE_PATH = "H:\\Project\\cloud\\dev-ssue-book.json";

	@Autowired
	UserAccountRepository repo;

	@Override
	public List<Object> listIssues() {
		
		final File issueFile = new File(FILE_PATH);

		JSONArray fileData = getFileDataIfPresent(issueFile);
		
		return fileData.toList();
	}

	@Override
	public void saveIssue(JSONObject issueJson) {

		final File issueFile = new File(FILE_PATH);

		JSONArray fileData = getFileDataIfPresent(issueFile);

		writeJsonObjectToFile(issueJson, fileData, issueFile);

	}

	private JSONArray getFileDataIfPresent(final File issueFile) {

		if (issueFile.exists()) {

			try (FileReader fileR = new FileReader(issueFile)) {

				return (JSONArray) new JSONTokener(fileR).nextValue();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return new JSONArray();
	}

	private void writeJsonObjectToFile(final JSONObject issueJson, final JSONArray fileData, final File issueFile) {

		try (FileWriter file = new FileWriter(issueFile, false)) {

			issueJson.put("id", UUID.randomUUID());

			if (nonNull(fileData)) {
                
				fileData.put(issueJson);
				file.write(fileData.toString());
			} else {

				JSONArray jsonArray = new JSONArray();
				jsonArray.put(issueJson);
				file.write(jsonArray.toString());
			}
			log.info("New issue added in a file: " + issueFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserAccount updateIssue(JSONObject issueJson, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
