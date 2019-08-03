# AppetiTunes

A simple app that uses MVVM Design Pattern. MVVM clearly separates UI from app logic, it has clean architecture. Since our goal is to persist data even if the user reopen the app, or change the screen orientation. ViewModel persists the data even if the Activity is destroyed and we can reuse it as long as the viewmodel is alive. Although there are cons that I encountered since I used databinding, I find it hard to debug since some code is in xml. 

Other dependencies used: 
-Glide: a lightweight image loader.
-Android data binding: Works well with MVVM and it significantly reduce boilerplate codes. 
-Room: persistence used for storing local data. 
-Retrofit: Easy to use for API calls.
