package com.myoffice.app.manager;

import com.onlyoffice.manager.settings.DefaultSettingsManager;
import com.onlyoffice.model.settings.SettingsConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class SettingsManagerImpl extends DefaultSettingsManager {
    private static Properties properties;

    static {
        properties = new Properties();
    }

    public SettingsManagerImpl(
            @Value("${onlyoffice.server.url}") final String docServerUrl,
            @Value("${onlyoffice.server.security.key}") final String securityKey
    ) {
        properties.put(SettingsConstants.URL, docServerUrl);
        properties.put(SettingsConstants.SECURITY_KEY, securityKey);
        properties.put("customization.forcesave", "true");
        properties.put("customization.spellcheck", "false");
    }

    @Override
    public String getSetting(final String name) {
        return properties.getProperty(name);
    }

    @Override
    public void setSetting(final String name, final String value) {
        properties.setProperty(name, value);
    }
}
