package ch.bfh.bti7081.s2017.green.ui.navigation;

/**
 * Created by Lukas on 26.05.2017.
 */

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewProvider;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.UI;
import org.springframework.context.ApplicationContext;

@SuppressWarnings("serial")
public class DashboardNavigator extends Navigator {

    private static final DashboardViewType ERROR_VIEW = DashboardViewType.MYDAY;
    private ViewProvider errorViewProvider;
    private ApplicationContext context;

    public DashboardNavigator(ApplicationContext context, ComponentContainer container) {
        super(UI.getCurrent(), container);
        this.context = context;

        // String host = getUI().getPage().getLocation().getHost();
        initViewChangeListener();
        initViewProviders();
    }

    private void initViewChangeListener() {
        addViewChangeListener(new ViewChangeListener() {

            @Override
            public boolean beforeViewChange(final ViewChangeEvent event) {
                // Since there's no conditions in switching between the views
                // we can always return true.
                return true;
            }

            @Override
            public void afterViewChange(final ViewChangeEvent event) {
            }
        });
    }

    private void initViewProviders() {
        // A dedicated view provider is added for each separate view type
        for (final DashboardViewType viewType : DashboardViewType.values()) {
            ViewProvider viewProvider = new ClassBasedViewProvider(viewType.getViewName(), viewType.getViewClass()) {

                // This field caches an already initialized view instance if the
                // view should be cached (stateful views).
                private View cachedInstance;

                @Override
                public View getView(final String viewName) {
                    View result = null;
                    if (viewType.getViewName().equals(viewName)) {
                        if (viewType.isStateful()) {
                            // Stateful views get lazily instantiated
                            if (cachedInstance == null) {
                                cachedInstance = context.getBean(viewType.getViewClass());
                            }
                            result = cachedInstance;
                        } else {
                            // Non-stateful views get instantiated every time
                            // they're navigated to
                            result = context.getBean(viewType.getViewClass());
                        }
                    }
                    return result;
                }
            };

            if (viewType == ERROR_VIEW) {
                errorViewProvider = viewProvider;
            }

            addProvider(viewProvider);
        }

        setErrorProvider(new ViewProvider() {
            @Override
            public String getViewName(final String viewAndParameters) {
                return ERROR_VIEW.getViewName();
            }

            @Override
            public View getView(final String viewName) {
                return errorViewProvider.getView(ERROR_VIEW.getViewName());
            }
        });
    }
}

