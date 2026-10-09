package br.com.componentes;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.com.componentes.baseadaper.BaseAdapter;
import br.com.componentes.baseadaper.OnViewHolderClickListener;
import br.com.componentes.databinding.ActivityMainBinding;
import br.com.componentes.extras.SizeDialog;
import br.com.componentes.extras.TypeDialog;
import br.com.componentes.extras.WindowFormat;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupAutocomplete();
        setupComponentList();
        setupInteractions();
    }

    private void setupAutocomplete() {
        binding.editTextTitleAutoComplete.setAdapter(
                new String[]{"Goiânia", "Goianésia", "Guarapari", "Guarulhos"}
        );
        binding.editTextTitleAutoComplete.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(
                        this,
                        String.valueOf(binding.editTextTitleAutoComplete.getAdapter().getItem(position)),
                        Toast.LENGTH_SHORT
                ).show()
        );
    }

    private void setupComponentList() {
        List<Cidade> cities = generateData();
        BaseAdapter<Cidade> adapter = new BaseAdapter<Cidade>(cities, new OnViewHolderClickListener() {
            @Override
            public void onClickListener(int position) {
                if (position >= 0 && position < cities.size()) {
                    Toast.makeText(MainActivity.this, cities.get(position).getNome(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onLongClickListener(int position) {
                if (position >= 0 && position < cities.size()) {
                    Toast.makeText(
                            MainActivity.this,
                            cities.get(position).getUf(),
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        }) {
            @Override
            protected int getItemView() {
                return R.layout.cidade_item;
            }

            @Override
            public void onBindViewHolder(ClickableViewHolder holder, int position) {
                Cidade cidade = getItem(position);
                ((TextView) holder.getViewById(R.id.nomeTextView)).setText(cidade.getNome());
                ((TextView) holder.getViewById(R.id.ufTextView)).setText(cidade.getUf());
            }
        };

        binding.recyclerViewButton.setAdapter(this, adapter);
    }

    private void setupInteractions() {
        binding.buttonValidate.setOnClickListener(view -> {
            boolean valid = binding.editTextTitle.validaPreenchido();
            int message = valid ? R.string.demo_field_valid : R.string.demo_field_invalid;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        });

        binding.editTextSearch.setOnClickListener(view ->
                Toast.makeText(this, binding.editTextSearch.getString(), Toast.LENGTH_SHORT).show()
        );

        binding.helpButton.setActivity(this);
        binding.helpButton.setHelpMsg(getString(R.string.demo_help_message));

        binding.progressButton.setOnClickListener(view -> {
            binding.progressButton.setProgres();
            handler.postDelayed(binding.progressButton::removeProgres, 1500);
        });

        binding.progressImageView.setOnClickListener(view -> {
            binding.progressImageView.setProgres();
            handler.postDelayed(binding.progressImageView::removeProgres, 1500);
        });

        binding.buttonProgressDialog.setOnClickListener(view -> {
            ProgressIndeterminate progress = ProgressIndeterminate.show(
                    this,
                    getString(R.string.demo_loading_message)
            );
            handler.postDelayed(progress::dismiss, 1500);
        });

        binding.buttonCustomDialog.setOnClickListener(view -> showCustomDialog());
        binding.buttonAlertDialog.setOnClickListener(view ->
                new CDialog(this)
                        .createAlert(
                                getString(R.string.demo_custom_dialog_message),
                                WindowFormat.BACKGROUND_OVAL,
                                TypeDialog.INFO,
                                SizeDialog.MEDIUM
                        )
                        .show()
        );
        binding.buttonKeyboardDialog.setOnClickListener(view -> showKeyboardDialog());
    }

    private void showCustomDialog() {
        try {
            new CustomDialog(this)
                    .setToolbarTitle(getString(R.string.demo_custom_dialog_title))
                    .setContentView(R.layout.dialog_component_sample)
                    .create()
                    .show();
        } catch (Exception exception) {
            Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void showKeyboardDialog() {
        try {
            new KeyBoardDialog(this)
                    .setJustNumber(false)
                    .create()
                    .show("", value -> Toast.makeText(
                            this,
                            getString(R.string.demo_keyboard_result, value),
                            Toast.LENGTH_SHORT
                    ).show());
        } catch (Exception exception) {
            Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private List<Cidade> generateData() {
        List<Cidade> data = new ArrayList<>();
        String[] cities = {"Goiânia", "Goianésia", "Guarapari", "Guarulhos"};
        String[] states = {"GO", "GO", "ES", "SP"};
        for (int i = 0; i < 12; i++) {
            int cityIndex = i % cities.length;
            data.add(new Cidade(cities[cityIndex], states[cityIndex]));
        }
        return data;
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
