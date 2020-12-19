
<link href="{{ asset('css/Searchbar.css') }}" rel="stylesheet">
<header class="header-search">
    <div class="header-limiter">
        <h1><a href="/">IUT<span>Drive</span></a></h1>
        <nav>
            <a href="/">Accueil</a>

            <a href="https://trello.com/b/jrMI35P2/drive" target="_blank">Trello</a>
        </nav>
        <div class="twice-phone">
            <form action="https://lucas-naveteur.fr/Artemis/public/index.php/specialSearch" method="post">
                {{ csrf_field() }}
                <div class="inner-form">
                    <div class="input-field first-wrap">
                        <div class="input-select">
                        <select data-trigger="Acheter" name="catégorie">
                            <option value="default" disabled value hidden>Catégories</option>
                            <option value="default" selected>Dossiers</option>
                            <option value="default">Fichiers</option>
                        </select>
                    </div>
                </div>
                <div class="input-field second-wrap">
                    <input id="search" name="searchData" type="text" placeholder="Je cherche..."/>
                </div>
                <div class="input-field third-wrap">
                <a>
                        <button class="btn-search" type="submit">
                        <svg class="svg-inline--fa fa-search fa-w-16" aria-hidden="true" data-prefix="fas" data-icon="search" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                            <path fill="currentColor" d="M505 442.7L405.3 343c-4.5-4.5-10.6-7-17-7H372c27.6-35.3 44-79.7 44-128C416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c48.3 0 92.7-16.4 128-44v16.3c0 6.4 2.5 12.5 7 17l99.7 99.7c9.4 9.4 24.6 9.4 33.9 0l28.3-28.3c9.4-9.4 9.4-24.6.1-34zM208 336c-70.7 0-128-57.2-128-128 0-70.7 57.2-128 128-128 70.7 0 128 57.2 128 128 0 70.7-57.2 128-128 128z"></path>
                        </svg>
                        </button>
                    </a>
                </div>
            </form>
            </div>
        </div>
            @if($user = Auth::user())
                <div class="header-user-menu">
                    <img src="{{ $user->image }}" alt="{{ $user->name }}"/>
                    <ul>
                        <li><a href="/user/profile">Profil</a></li>
                        <li><a href="/user/groups">Mes groupes</a></li>
                        <li><a href="/user/circles">Mes cercles</a></li>
                        <li><a href="/auth/disconnection" class="highlight">Deconnexion</a></li>
                    </ul>
                </div>
            @else
                <ul>
                    <li><a href="login">Connexion</a></li>
                    <li><a href="register">Inscription</a></li>
                </ul> 
            @endif
    </div>
</header>
