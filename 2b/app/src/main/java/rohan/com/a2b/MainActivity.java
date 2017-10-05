package rohan.com.a2b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Model> data;
    ListView listView;
    double sum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<Model>();
        data.add(new Model("Potato",25));
        data.add(new Model("Tomato",40));
        data.add(new Model("Pyaaz",35));
        data.add(new Model("Gobhi",40));
        data.add(new Model("Baigan",20));
        data.add(new Model("Laddu",5));

        Button btn = (Button) findViewById(R.id.button1);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomAdapter(this,data));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(Model model : data){
                    if(model.isSelected()) {
                        sum += (model.getPrice() * model.getQuant());
                    }
                }
                Toast.makeText(MainActivity.this,"Total Payable Amount = " + sum + "  :P",Toast.LENGTH_SHORT).show();
                sum=0;
            }
        });
    }

}
