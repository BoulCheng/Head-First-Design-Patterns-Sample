package headfirst.designpatterns.singleton.enums;

/**
 * Created by yuanming
 * Created 2021-05-12
 * Modify:
 *
 *
 *
 *
 * appledeiMac:enums apple$
 * appledeiMac:enums apple$ javac Color.java
 * appledeiMac:enums apple$
 * appledeiMac:enums apple$ javap Color
 * 警告: 二进制文件Color包含headfirst.designpatterns.singleton.enums.Color
 * Compiled from "Color.java"
 * public final class headfirst.designpatterns.singleton.enums.Color extends java.lang.Enum<headfirst.designpatterns.singleton.enums.Color> {
 *   public static final headfirst.designpatterns.singleton.enums.Color RED;
 *   public static final headfirst.designpatterns.singleton.enums.Color GREEN;
 *   public static final headfirst.designpatterns.singleton.enums.Color BLUE;
 *   public static final headfirst.designpatterns.singleton.enums.Color YELLOW;
 *   public static headfirst.designpatterns.singleton.enums.Color[] values();
 *   public static headfirst.designpatterns.singleton.enums.Color valueOf(java.lang.String);
 *   static {};
 * }
 * appledeiMac:enums apple$
 *
 *
 */
public enum Color {
    RED(), GREEN(), BLUE(), YELLOW();
}

