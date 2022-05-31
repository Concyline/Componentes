package br.com.componentes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.componentes.baseadaper.BaseAdapter;
import br.com.componentes.baseadaper.OnViewHolderClickListener;

public class MainActivity extends AppCompatActivity implements OnViewHolderClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
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
        });


    }

    private List<Cidade> generateData() {
        List<Cidade> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(new Cidade("Cidade " + i, "UF " + i));
        }
        return data;
    }

    @Override
    public void onClickListener(int positionOfItem) {
        System.out.println("onClickListener");
    }

    @Override
    public void onLongClickListener(int position) {
        System.out.println("onLongClickListener");
    }

    public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private LayoutInflater mInflater;
        private List<Cidade> lCidade;

        Adapter(List<Cidade> lCidade) {
            this.mInflater = LayoutInflater.from(getBaseContext());
            this.lCidade = lCidade;
        }

        @Override
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.cidade_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            final ViewHolder viewHolder = (ViewHolder) holder;

            Cidade cidade = lCidade.get(position);

            viewHolder.nomeTextView.setText(cidade.getNome());
            viewHolder.ufTextView.setText(cidade.getUf());
        }

        @Override
        public int getItemCount() {
            return lCidade.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView nomeTextView;
            TextView ufTextView;

            ViewHolder(View itemView) {
                super(itemView);
                nomeTextView = itemView.findViewById(R.id.nomeTextView);
                ufTextView = itemView.findViewById(R.id.ufTextView);
            }
        }

        Cidade getItem(int id) {
            return lCidade.get(id);
        }
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
        protected int[] getResIdOfInflatedViews() {
            return new int[]{R.id.nomeTextView, R.id.ufTextView};
        }

        @Override
        public void onBindViewHolder(ClickableViewHolder holder, int position) {

            final Cidade item = getItem(position);

            ((TextView) holder.getViewById(getResIdOfInflatedViews()[0])).setText(item.getNome());
            ((TextView) holder.getViewById(getResIdOfInflatedViews()[1])).setText(item.getUf());

        }
    }
}