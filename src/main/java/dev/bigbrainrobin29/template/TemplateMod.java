package dev.bigbrainrobin29.template;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public class TemplateMod {
    public static final Logger LOGGER = LogUtils.getLogger();

    public static void initialize() {
        LOGGER.info("Hello from TemplateMod!");
    }
}
