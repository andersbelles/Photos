# Photos 
> List of photos and details
## Tech stack:
- Kotlin (with Coroutines)
- Koin as a dependency injection framework
- Navigation component
- ViewModel, LiveData, View Binding
- RecyclerView (with DiffUtil executing on a background thread)
- Retrofit
- Moshi
- Glide

The app is built on MVVM architectural pattern using multi-module Clean Architecture approach.

<img src="https://miro.medium.com/max/579/1*Vx08QVJWuGzE4THnpq7FsA.png" width="240">

## Installation

- Android Studio 4.2.1 with Kotlin plugin 1.5.10 is required to run the app.

## 2 things I solved well in my opinion:
- Architecture (in terms of clean approach)
- Navigation (using single activity approach)

## 2 things I'd improve if I had more time:
- Add Pagination
- Cover with Unit tests

## Rest of the things I would improve:
- Talk to backend team and ask them to add extensions to image URLs
- Handle server errors
- Fix RecyclerView state loss on config changes
- Add UiStates to Details page
- Use Kotlin Flows instead of LiveData
