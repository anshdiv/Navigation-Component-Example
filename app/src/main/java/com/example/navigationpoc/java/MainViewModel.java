package com.example.navigationpoc.java;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

class MainViewModel extends ViewModel {

    private MutableLiveData<String> schoolName = new MutableLiveData<>();

    public MutableLiveData<String> getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName.setValue(schoolName);
    }


}