package dk.tec.todolistfinal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        View button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateToDoActivity.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //startActivity(new Intent(this, CreateTodoActivity.class));
        requestQueue = Volley.newRequestQueue(this);
        getTodoItem();
    }
    void getTodoItem(){
        StringRequest request = new StringRequest(
                Request.Method.GET, "http://192.168.147.1:8989/todoitem",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Type listType = new TypeToken<List<TodoItem>>() {
                        }.getType();
                        List<TodoItem> todoItems = new Gson().fromJson(response, listType);
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("****Vollet****", "onErrorResponse:", error);
                    }
                }
        );
        requestQueue.add(request);  // Add the request to the queue to execute it

    }
    void createTodoItem(){
        TodoItem todoItem= new TodoItem();
        todoItem.setName("Dikshya");
        Map<String, String> param= new HashMap<String, String>();
        param.put("todo",new Gson().toJson(todoItem));

//        JsonObjectRequest request= new JsonObjectRequest(
//                Request.Method.POST,
//                "http://192.168.147.1:8989/todoitem",
//                new JSONObject(param),
//                new Response.Listener<JSONObject>() {
//                    @Override
////                    public void onResponse(JSONObject response) {
////
//                    }
//                },
//                @Override
//                public void onErrorresponse(VolleyError){
//
//        });

    }
}
