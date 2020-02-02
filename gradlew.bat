package com.moshiurcse.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.moshiurcse.employeemanagement.models.BasePlusCommisionEmployee;
import com.moshiurcse.employeemanagement.models.BaseSalarriedEmployee;
import com.moshiurcse.employeemanagement.models.Employee;
import com.moshiurcse.employeemanagement.models.HourlySalarriedEmployee;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText nameET,dobET,phoneET,emailET,baseSalaryET,totalHourET,hourlyRateET,commitionRateET,grossSaleET;

    private RadioGroup genderRG,typeRG;

    private String gender="Male";
    private String emp_type="Base Salaried Employee";
    private String dob="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameET=findViewById(R.id.empNameInput);
        dobET=findViewById(R.id.empDobInput);
        phoneET=findViewById(R.id.empPhoneInput);
        emailET=findViewById(R.id.empEmailInput);
        baseSalaryET=findViewById(R.id.baseSalaryInput);
        totalHourET=findViewById(R.id.totalHourInput);
        hourlyRateET=findViewById(R.id.hourlyRateInput);
        commitionRateET=findViewById(R.id.commisionRateInput);
        grossSaleET=findViewById(R.id.grossSaleInput);

        genderRG=findViewById(R.id.genderTypeRadioGroup);
        typeRG=findViewById(R.id.empTypeTypeRadioGroup);

        genderRG.setOnCheckedChangeListener(ne