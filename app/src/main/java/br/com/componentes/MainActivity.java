package br.com.componentes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.componentes.baseadaper.BaseAdapter;
import br.com.componentes.baseadaper.OnViewHolderClickListener;

public class MainActivity extends AppCompatActivity implements OnViewHolderClickListener {

    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditTextTitle editTextTitle = findViewById(R.id.editTextTitle);
        editTextTitle.setTextT("aqui");

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(""+editTextTitle.validaPreenchido());
            }
        });


        EditTextTitleAutoComplete editTextTitleAutoComplete = findViewById(R.id.editTextTitleAutoComplete);
        editTextTitleAutoComplete.setAdapter(new String[]{"goiania", "goianesia", "guarapari", "guarulhos"});

        editTextTitleAutoComplete.setOnItemClickListener((parent, view, position, id) -> {
            System.out.println(" " + editTextTitleAutoComplete.getAdapter().getItem(position));
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


        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(BaseAdapter.getGridLayoutManager(this));
        recyclerView.addItemDecoration(BaseAdapter.getDividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //recyclerView.addItemDecoration(BaseAdapter.getDividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));

        customAdapter = new CustomAdapter(generateData(), this);
        recyclerView.setAdapter(customAdapter);


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

        this.positionOfItem = positionOfItem;
        customAdapter.notifyDataSetChanged();

        Cidade item = ((CustomAdapter) recyclerView.getAdapter()).getItem(positionOfItem);

        System.out.println("");

    }

    @Override
    public void onLongClickListener(int position) {
        System.out.println("onLongClickListener");
    }

    public class CustomAdapter extends BaseAdapter<Cidade> {

        public CustomAdapter(List<Cidade> data, OnViewHolderClickListener itemClickListener) {
            super(data, itemClickListener);
        }

        @Override
        protected int getItemView() {
            return R.layout.cidade_item;
        }

        @Override
        public void onBindViewHolder(ClickableViewHolder holder, int position) {

            final Cidade item = getItem(position);

            ((TextView) holder.getViewById(R.id.nomeTextView)).setText(item.getNome());
            ((TextView) holder.getViewById(R.id.ufTextView)).setText(item.getUf());

            holder.itemView.setBackgroundColor(positionOfItem == position
                    ? Color.parseColor("#CCCCCC")
                    : Color.parseColor("#FFFFFF"));

        }

    }
}