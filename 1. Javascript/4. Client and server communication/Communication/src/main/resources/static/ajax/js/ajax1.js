class Controller {
    constructor() {
        document.getElementById("requestData").addEventListener("click",this.#sendRequest.bind(this));
    }

    async #sendRequest() {
        try {
            const response = await fetch("dok/demo1.txt");
            console.log(`Got response from server: ${response}`);
        } catch (e) {
            console.log(`Got error: ${e.message}.`);
        }
    }
}

new Controller;
