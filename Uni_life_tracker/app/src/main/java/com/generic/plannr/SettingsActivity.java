package com.generic.plannr;

import com.generic.plannr.Database.UserInfoDatabaseHelper;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {
    // initialize variable
    DrawerLayout drawerLayout;

    private TextInputEditText etName;
    private TextInputEditText etUni;
    private TextInputLayout tiName;
    private TextInputLayout tiUni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        drawerLayout = findViewById(R.id.drawer_layout); // nav menu

        // accesses user info from text boxes
        etName = findViewById(R.id.et_name);
        etUni = findViewById(R.id.et_uni);
        tiName = findViewById(R.id.ti_name);
        tiUni = findViewById(R.id.ti_university);

        // opens the database to retrieve user's name and uni
        UserInfoDatabaseHelper user = createDatabase();
        etName.setText(user.getLoggedInName());
        etUni.setText(user.getLoggedInUni());
    }

    public void clickMenu(View view) { MainPageActivity.openDrawer(drawerLayout); } // open drawer

    public void clickLogo(View view) { MainPageActivity.closeDrawer(drawerLayout); } // close drawer

    public void clickSchool(View view) { MainPageActivity.redirectActivity(this, SchoolActivity.class); } // redirect activity to school

    // TODO: change this to life later
    public void clickLife(View view) { MainPageActivity.redirectActivity(this, MainPageActivity.class); } // redirect activity to life

    public void clickExpenses(View view) { MainPageActivity.redirectActivity(this, ExpensesActivity.class); } // redirect activity to expenses

    public void clickSettings(View view) { recreate(); } // recreate activity

    public void clickSave(View view) {
        // gets user input from textbox
        String name = Objects.requireNonNull(tiName.getEditText()).getText().toString();
        String uni = Objects.requireNonNull(tiUni.getEditText()).getText().toString();
        // opens database
        UserInfoDatabaseHelper user = createDatabase();
        // replaces current data in database with user input
        user.updateName(name);
        user.updateUni(uni);
        // disables textbox so it becomes read only
        textboxEditability(false);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainPageActivity.closeDrawer(drawerLayout); // close drawer
    }

    public void clickEdit(View view) {
        // enabled textboxes so they can be edited
        textboxEditability(true);
    }

    public UserInfoDatabaseHelper createDatabase() {
        // creates an instance and opens database
        UserInfoDatabaseHelper user = new UserInfoDatabaseHelper(SettingsActivity.this);
        user.openDatabase();
        return user;
    }

    public void textboxEditability(boolean bool) {
        etName.setEnabled(bool);
        etUni.setEnabled(bool);
    }

}