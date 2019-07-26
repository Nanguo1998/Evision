package com.example.e.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * @deprecated 权限管理
 */
public class PermissionUtil {
    public static final String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
    public static final List<String> aleary_permissions = new ArrayList<>();
    public static final int REQUEST_PERMISSION_CALL = 100;
    public static boolean isWindwos = false;
    public PermissionUtil() {
    }

    //检测权限
    public static void checkPermissions(Context context){
        aleary_permissions.clear();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            for(int i = 0 ; i < permissions.length ; i++){
                if(ContextCompat.checkSelfPermission(context,permissions[i]) != PackageManager.PERMISSION_GRANTED)
                    aleary_permissions.add(permissions[i]);
            }
        }
    }

    public static boolean checkPermission(Context context,String permission){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ContextCompat.checkSelfPermission(context,permission) == PackageManager.PERMISSION_GRANTED)
                return true;
            else
                return false;
        }
        return true;
    }

    public static void startRequestPermission(Activity activity){
            ActivityCompat.requestPermissions(activity,permissions,REQUEST_PERMISSION_CALL);
    }

    public static void startRequestPermission(Activity activity,String permission){
        if(!aleary_permissions.isEmpty()) {
            ActivityCompat.requestPermissions(activity, aleary_permissions.toArray(new String[aleary_permissions.size()]), REQUEST_PERMISSION_CALL);
        }
    }

    public static void checkWindowPermission(Context context){
        if(Build.VERSION.SDK_INT >=23){
            if(!Settings.canDrawOverlays(context)){
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                ((Activity)context).startActivityForResult(intent,101);
            }
            else
                isWindwos = true;
        }
    }

}
