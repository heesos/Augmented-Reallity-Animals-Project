package com.google.ar.university.project.app;

import java.io.File;

public class Method {

    public static boolean load_Directory_Files(File directory){
        File[] fileList = directory.listFiles();
        boolean flag=false;
        if(fileList != null && fileList.length > 0){
            for (int i=0; i<fileList.length; i++){
                if(fileList[i].isDirectory()){
                    load_Directory_Files(fileList[i]);
                    flag=true;
                }
                else {
                    String name = fileList[i].getName().toLowerCase();
                    for (String extension: Constant.videoExtensions){
                        //check the type of file
                        if(name.endsWith(extension)){
                            Constant.allMediaList.add(fileList[i]);
                            //when we found file
                            flag=true;
                            break;
                        }
                    }
                }
            }
        }
        return flag;
    }

}
