# android_zimad

**Status:** In progress

**About:** Test work for position android developer in Zimad

**Технологии:** _Java, Android SDK, Architecture Components (LiveData, ViewModel), Retrofit2, RxJava2, Gson, Picasso, TabLayout, RecyclerView_

**Архиектура:** _Clean Architecture, MVVM_

**Описание:** 

Надо сделать окно с двумя вкладками. 
На обеих вкладках отображается список данных (картинка + текст). 
По клику на элемент списка открывается детальная страница.
На детальной странице отображается картинка и текст.

**API для вкладки 1:**

http://kot3.com/xim/api.php?query=cat

**API для вкладки 2:**

http://kot3.com/xim/api.php?query=dog

При клике кнопки "назад" на детальной - происходит возврат на список элементов.
При клике кнопки "назад" на списке элементов - происходит выход из программы.

1. На каждой вкладке должен быть отдельный _fragment_.
2. При переходах на детальную страницу и при переключении вкладок в списках должны сохраняться сами данные и положения скроллов.  
3. Приложение должно поддерживать поворот экрана.
После поворота должен сохраниться стек окон, выбранная вкладка, загруженные данные и положения скроллов в самих списках.
Не использовать _retain fragment_ и _setRetainInstance_.
У _activity_ не использовать _android:configChanges="orientation|screenSize..."_
Необходимо использовать: _Fragments API_, _Retrofit_ для работы с _api_, _TabLayout_, _RecyclerView_, _Picasso_
Между вкладками можно переключаться только кликом на вкладку. (_ViewPager_ не использовать). 
Использовать стандартный вид элементов, дизайн не важен. Всё, что не описано-делать не нужно.
Использование MV* шаблонов разработки пользовательского интерфейса и _Clean Architecture_ будет плюсом. (Реализация своя, без _Moxy_ и прочих)
Тестовое задание должно быть выполнено на _Java_. Залить желательно на гит.

![Screen layout](https://github.com/elsemTim/android_zimad/blob/master/about/Mockup_Android%20dev_test_MJP.png)
