package info.hct.com.deviceinfo;

import android.os.Build;

/**
 * Created by root on 17-3-29.
 */
public class DeviceInfo {
/*
    ro.product.model
    ro.product.brand
    ro.product.name
    ro.product.device
    ro.product.manufacturer
    ro.build.description
    ro.build.fingerprint
    ro.build.date.utc
    ro.build.date
    ro.build.id
    ro.build.display.id
    ro.build.version.incremental
    ro.build.tags
*/

    String model;
    String brand;
    String name;
    String device;
    String manufacturer;
    String description;
    String fingerprint;
    String date_utc;
    String date;
    String id;
    String display_id;
    String version_incremental;
    String tags;

    public DeviceInfo(){

    }

    public DeviceInfo(String model) {
        this.model = model;
    }

    public DeviceInfo(String model, String brand, String name,
                      String device, String manufacturer, String description,
                      String fingerprint, String date_utc, String date,
                      String id, String display_id, String version_incremental,
                      String tags) {
        this.model = model;
        this.brand = brand;
        this.name = name;
        this.device = device;
        this.manufacturer = manufacturer;
        this.description = description;
        this.fingerprint = fingerprint;
        this.date_utc = date_utc;
        this.date = date;
        this.id = id;
        this.display_id = display_id;
        this.version_incremental = version_incremental;
        this.tags = tags;
    }

    /*
            获取设备品牌
            */
    public  static  String getDeviceBoardInfo(){
        return Build.BOARD;
    }

    /*
    获取设备制造商
     */
    public static String getDeviceManufacturerInfo(){
        return Build.MANUFACTURER;
    }
    /*
    获取设备型号
     */
    public static String getDeviceModelInfo(){
        return Build.MODEL;
    }
    /*
    获取fingerprint
     */
    public static String getDeviceFingerprintInfo(){

        return Build.FINGERPRINT;
    }





}
