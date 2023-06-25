package com.example.babyone;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.HashMap;

public class first_time_guardian_personal extends Fragment {
    private HashMap<String, String> editTextMap = new HashMap<>();
    private EditText edtEPFullName;
    private EditText edtEPPhoneNumber;

    private RadioGroup radgroupEPRelation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_time_guardian_personal, container, false);

        // initialize components
        edtEPFullName = view.findViewById(R.id.edtEPFullName);
        edtEPPhoneNumber = view.findViewById(R.id.edtEPPhoneNumber);
        radgroupEPRelation = view.findViewById(R.id.radgroupEPRelation);
        //TODO: Implement relationship to the baby radio button


        // Inflate the layout for this fragment
        return view;
    }

    //@Override
    public HashMap<String, String> getInfoHashMap() {
        // Return the hashmap
        String fullName = edtEPFullName.getText().toString().trim();
        String phoneNumber = edtEPPhoneNumber.getText().toString().trim();

        if (!fullName.isEmpty()) {
            editTextMap.put("parentname", fullName);
        }

        if (!phoneNumber.isEmpty()) {
            editTextMap.put("phonenumber", phoneNumber);
        }
        // Retrieve the selected radio button ID
        int selectedRadioButtonId = radgroupEPRelation.getCheckedRadioButtonId();
        // Determine the selected radio button text based on its ID
        String relationship;
        if (selectedRadioButtonId == R.id.radbtnEPMother) {
            relationship = "Mother";
        } else if (selectedRadioButtonId == R.id.radbtnEPFather) {
            relationship = "Father";
        } else if (selectedRadioButtonId == R.id.radbtnEPOther) {
            relationship = "Other";
        } else {
            relationship = ""; // Default value if no radio button is selected
        }

        // Add the relationship to the HashMap
        if (!relationship.isEmpty()) {
            editTextMap.put("relationship", relationship);
        }
        return editTextMap;
    }
}