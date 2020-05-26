package com.example.lab5exam02.externalStorage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Properties;

class TestConfig {
    @SuppressLint("SdCardPath")
    private static final String STR_CONFIG_FILE = "study.ini";
    private static HashMap<String, Properties> sections = new HashMap<>();
    private static transient Properties properties;
    @SuppressLint("StaticFieldLeak")
    private static TestConfig sConfigMgr;
    private final Context mContext;

    TestConfig(Context context) {
        mContext = context;
    }

    static synchronized TestConfig getInstance(Context context) {
        if (null == sConfigMgr) {
            sConfigMgr = new TestConfig(context);
        }
        return sConfigMgr;
    }

    String readProperties(String section, String key) {
        FileInputStream inputStream = null;
            try {
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+
                        File.separator+"demo",STR_CONFIG_FILE);
            inputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            read(reader);
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Properties p = sections.get(section);

        if (p == null) {
            return null;
        }

        return p.getProperty(key);
    }

    private void read(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            parseLine(line);
        }
    }

    private void parseLine(String line) {
        line = line.trim();
        if (line.matches("\\[.*\\]")) {
            String section = line.replaceFirst("\\[(.*)\\]", "$1");
            properties = new Properties();
            sections.put(section, properties);
        } else if (line.matches(".*=.*")) {
            if (properties != null) {
                int i = line.indexOf('=');
                String name = line.substring(0, i);
                String value = line.substring(i + 1);
                properties.setProperty(name, value);
            }
        }
    }
}
