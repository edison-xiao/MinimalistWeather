package me.baron.weatherstyle.activities.component;

import dagger.Component;
import me.baron.weatherstyle.activities.SelectCityActivity;
import me.baron.weatherstyle.presenter.module.SelectCityPresenterModule;

/**
 * @author 张磊 (baronzhang[at]anjuke[dot]com)
 *         2016/11/30
 */
@Component(modules = SelectCityPresenterModule.class)
public interface SelectCityComponent {

    void inject(SelectCityActivity selectCityActivity);
}