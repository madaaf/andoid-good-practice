package com.octo.android.goodpracticies;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.octo.android.goodpracticies.actitvityWithLibraries.EmployeesWLActivity;
import com.octo.android.goodpracticies.network.service.IEmployeeService;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

/**
 * Created by madaaflak on 12/01/2016.
 */
public class GoodPracticiesApplication extends Application {

	private static GoodPracticiesApplication app;
	private static Context context;
	private GPComponent component;


	@Override
	public void onCreate() {
		super.onCreate();
		app = this;
		this.context = getApplicationContext();
		component = DaggerGoodPracticiesApplication_GPComponent.builder().gPModule(new GPModule(this)).build();

	}

	public static GoodPracticiesApplication app() {
		return app;
	}

	public GPComponent getComponent() {
		return component;
	}

	@Component(modules = {GPModule.class})
	@Singleton
	public interface GPComponent {
		void inject(EmployeesWLActivity activity);
	}


	@Module
	public static class GPModule {
		private final GoodPracticiesApplication appl;
		private final RestAdapter restAdapter;

		public GPModule(GoodPracticiesApplication app) {
			this.appl = app;
			this.restAdapter = new RestAdapter.Builder().setEndpoint(BuildConfig.rootUrl).build();
			Log.e("SOEF2", BuildConfig.rootUrl);
		}

		@Provides
		GoodPracticiesApplication providesApp() {
			return appl;
		}

		@Provides
		@Singleton
		public IEmployeeService providesRestAdapter() {
			return restAdapter.create(IEmployeeService.class);
		}

		@Provides
		@Singleton
		public Bus providesBus() {
			return new Bus();
		}


		@Provides
		public Context providesContext() {
			return context;
		}

	}
}
