# KotlinMVIDemo

This is a basic project that showcases the use of MVI (Model View Intent) Architecture on Android.

It uses the [MovieDB API](https://developers.themoviedb.org/3/getting-started/introduction) to retrieve a list of popular movies and the detail of a selected movie.

To run this you need to register on the site and get an API Token, you will add this on the *keys.properties* file under the app/ folder


### Architecture Diagram
Below is a diagram that shows the flow of information on the application.

The classes at the top are the classes used in the flow and the bold ones to the right are the entities used in the flow

![MVI Diagram](/diagram.png)

The flow of information is as follows:

- The `GridFragment` class will dispatch a `GridEvent` object when an action is triggered on the UI
- The `GridViewmodel` will observe this event using LiveData and will respond to any changes
- When there's a change to the `GridEvent` LiveData, depending on the event the ViewModel will dispatch an action to the `GridRepository` to request a resource
- The `GridRepository` will then return the specified resource as a `DataState` object
- The ViewModel will relay back this resource to the GridFragment via a `DataState` observable
- The `GridFragment` will observe the DataState and react to it, depending on the available resource on the DataState object, the Grid Fragment will dispatch said
resource to the ViewModel
- The ViewModel will react to it via a `ViewState` observable, when any resource is updated the ViewModel will relay back this update to the Grid Fragment via the
ViewState observable
- The `GridFragment` will observe the ViewState and react to it, depending on the available resource it will update the UI Accordingly
