function goBack() {
    if(document.referrer.includes(window.location.hostname)) { // le document de l'url n'est pas trouvé, il n'y a pas de retour arrère possible
        window.history.back();
    } else {
        window.location.href = "/";
    }
}