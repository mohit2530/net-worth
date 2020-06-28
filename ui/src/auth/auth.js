
/**
 * Class Auth : authenticate the user from the ui side.
 */


class Auth {
    constructor() {
        this.authenticated = false;
    }

    login(callback) {
        this.authenticated = true;
        callback();
    }

    logout(callback) {
        this.authenticated = false;
        callback();

    }

    isAuthenticated() {
        return this.authenticated;
    }
}

export default new Auth();