package com.twodeveloperscat.mmorpg;

import com.twodeveloperscat.mmorpg.aui.AuthenticationAndRegistrationPage;
import com.twodeveloperscat.mmorpg.persistense.json.FileDirectoryChecker;

public class Main {

	public static void main(String[] args) {
		FileDirectoryChecker.startCheck();
		AuthenticationAndRegistrationPage.mainPage();
	}
}
