package utils;

import driver.Config;

public class FileUtil {
    public static Config getConfig(){
        return Config.load("/data/config.yaml");
    }
}
