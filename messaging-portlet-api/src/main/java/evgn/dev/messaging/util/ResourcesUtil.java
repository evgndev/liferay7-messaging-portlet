package evgn.dev.messaging.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoaderUtil;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class ResourcesUtil {

    private static final Log LOG = LogFactoryUtil.getLog(ResourcesUtil.class);

    public static final String SERVLET_CONTEXT_NAME = "messagingportletapi";

    public static final String RU = "ru";
    public static final String EN = "en";
    public static final String FR = "fr";

    private static Map<String, ResourceBundle> resourcesMap;

    private ResourcesUtil() {
    }

    private static ResourcesUtil instance;

    public static ResourcesUtil getInstance() {
        if (instance == null)
            instance = new ResourcesUtil();
        return instance;
    }

    public static String getString(ResourceBundle resources, String key) {
        String result = null;
        try {
            result = resources.getString(key);
        } catch (Exception e) {

        }
        if (result == null) {
            return key;
        } else {
            return result;
        }
    }

    public static String getString(String key) {
        return getString(resourcesMap.get(RU), key);
    }

    public static String getString(Locale locale, String key) {
        try {
            if (resourcesMap == null) {
                initResources();
            }

            String language = locale.getLanguage();
            if (!resourcesMap.containsKey(language)) {
                language = RU;
            }
            ResourceBundle resourceBundle = resourcesMap.get(language);

            return resourceBundle.getString(key);
        } catch (Exception e) {
            LOG.error("Cannot get translation for " + key);
        }
        return key;
    }

    public static void initResources() {
        LOG.info("Init language resources");

        ResourceBundleLoader resourceBundleLoader = ResourceBundleLoaderUtil.
                getResourceBundleLoaderByServletContextName(SERVLET_CONTEXT_NAME);

        ResourceBundle resourceRu = resourceBundleLoader.loadResourceBundle(RU);
        ResourceBundle resourceEn = resourceBundleLoader.loadResourceBundle(EN);
        ResourceBundle resourceFr = resourceBundleLoader.loadResourceBundle(FR);

        resourcesMap = new HashMap<>();
        resourcesMap.put(RU, resourceRu);
        resourcesMap.put(EN, resourceEn);
        resourcesMap.put(FR, resourceFr);
    }
}
