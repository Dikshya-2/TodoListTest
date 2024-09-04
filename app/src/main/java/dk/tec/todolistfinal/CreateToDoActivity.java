package dk.tec.todolistfinal;


import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import dk.tec.todolistfinal.R;

//import dk.tec.todolistfinal.Tasktype;
//import dk.tec.catchingtodolist.model.Tasktype;
//import dk.tec.catchingtodolist.model.TodoItem;
public class CreateToDoActivity extends AppCompatActivity {
    TodoItem todoItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_to_do);

        findViewById(R.id.button).setOnClickListener(view -> {
            // Assume XP and streak are calculated here based on some conditions
            int xp = 50; // Example XP
            int streakBonus = TodoHelper.calculateStreakBonus(3); // Example streak
            int comboBoost = TodoHelper.calculateComboBoostXP(2); // Example combo

            todoItem.setXp(xp + streakBonus + comboBoost);

            TodoHelper.showXPToast(this, todoItem.getXp());
            TodoHelper.showTaskNotification(this, todoItem.getName());

            saveTodoItem();  // Save the TodoItem
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        todoItem = new TodoItem();

        findViewById(R.id.button).setOnClickListener(view -> {
            // Here you can save the TodoItem and trigger XP, notifications, etc.

            todoItem = new TodoItem();
            createSpinner();
            //createPriorityRadioGroup();
        });

        createSpinner();
        //createPriorityRadioGroup();
    }

    void createSpinner() {
        Spinner taskSpinner = findViewById(R.id.sp_tasktype);
        ArrayAdapter<Tasktype> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Tasktype.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        taskSpinner.setAdapter(adapter);

        taskSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                todoItem.setTasktype(Tasktype.values()[i]);
                Log.d("Tag", "onItemSelect: " + todoItem.getTasktype());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

//    void createPriorityRadioGroup() {
//        RadioGroup rgPriority = findViewById(R.id.rg_priority);
//        rgPriority.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//                    case R.id.rb_high:
//                        todoItem.setPriority(TodoItem.Priority.HIGH);
//                        break;
//                    case R.id.rb_normal:
//                        todoItem.setPriority(TodoItem.Priority.NORMAL);
//                        break;
//                    case R.id.rb_low:
//                        todoItem.setPriority(TodoItem.Priority.LOW);
//                        break;
//                }
//
//            }
//        });
  //  }

    void saveTodoItem() {
        // Implement saving logic here (e.g., save to the database, or send to a server)
        Log.d("Tag", "TodoItem Saved: " + todoItem.getName());
        // Trigger XP toast, notifications, etc.
    }


}
