package br.com.componentes;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import br.com.componentes.baseadaper.BaseAdapter;
import br.com.componentes.baseadaper.OnViewHolderClickListener;
import br.com.componentes.databinding.ActivityMainBinding;
import android.R;

public class MainActivity extends AppCompatActivity implements OnViewHolderClickListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(""+binding.editTextTitle.validaPreenchido());
            }
        });



        binding.editTextTitleAutoComplete.setAdapter(new String[]{"goiania", "goianesia", "guarapari", "guarulhos"});

        binding.editTextTitleAutoComplete.setOnItemClickListener((parent, view, position, id) -> {
            System.out.println(" " + binding.editTextTitleAutoComplete.getAdapter().getItem(position));
        });


        /*findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditTextTitle editTextTitle = findViewById(R.id.editTextTitle);

                editTextTitle.setError("fudeu mano");
            }
        });

        EditTextTitle senhaEditTextTitleafdsfsdf = findViewById(R.id.senhaEditTextTitleafdsfsdf);
        senhaEditTextTitleafdsfsdf.setOnClickListenerIconRigth(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senhaEditTextTitleafdsfsdf.mostraSenha();
            }
        });*/



        binding.recyclerView.setLayoutManager(BaseAdapter.getGridLayoutManager(this));
        binding.recyclerView.addItemDecoration(BaseAdapter.getDividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //recyclerView.addItemDecoration(BaseAdapter.getDividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));


    }

    private List<Cidade> generateData() {
        List<Cidade> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(new Cidade("Cidade " + i, "UF " + i));
        }
        return data;
    }


    int positionOfItem = -1;

    @Override
    public void onClickListener(int positionOfItem) {
        System.out.println("onClickListener");

    }

    @Override
    public void onLongClickListener(int position) {
        System.out.println("onLongClickListener");
    }



}