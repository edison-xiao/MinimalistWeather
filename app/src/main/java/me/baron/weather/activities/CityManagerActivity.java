package me.baron.weather.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.baron.library.activity.BaseActivity;
import me.baron.library.utils.ActivityUtils;
import me.baron.weather.R;
import me.baron.weather.WeatherApp;
import me.baron.weather.activities.component.DaggerCityManagerComponent;
import me.baron.weather.presenters.CityManagerPresenter;
import me.baron.weather.activities.module.CityManagerModule;
import me.baron.weather.views.fragments.CityManagerFragment;

/**
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 */
public class CityManagerActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    CityManagerPresenter cityManagerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_manager);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        CityManagerFragment cityManagerFragment = CityManagerFragment.newInstance(3);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), cityManagerFragment, R.id.fragment_container);

        DaggerCityManagerComponent.builder()
                .applicationComponent(WeatherApp.getInstance().getApplicationComponent())
                .cityManagerModule(new CityManagerModule(cityManagerFragment))
                .build().inject(this);
    }
}
