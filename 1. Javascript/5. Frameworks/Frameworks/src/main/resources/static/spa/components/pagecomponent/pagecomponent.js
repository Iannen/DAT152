const path = import.meta.url.match(/(.*\/spa)/)[1];
const template = document.createElement("template");
template.innerHTML = `
    <h1 id="header"></h1>

    <p>Open network tab in browser and observe that non of the below links results in a server request.</p>

    <p id="info"></p>

    <p>URLs in application:</p>
    <ul>
        <li><a href="${path}/routing/index.html">${path}/routing/index.html</a></li>
        <li><a href="${path}/routing/pageone">${path}/routing/pageone</a></li>
        <li><a href="${path}/routing/pagetwo">${path}/routing/pagetwo</a></li>
    </ul>`;


class Page extends HTMLElement {
    #shadow;
    #callbacks = new Map();
    #callbackId = 0;

    constructor() {
        super();

        const content = template.content.cloneNode(true);
        content.querySelectorAll("a").forEach(
            a => { a.addEventListener("click", this.#update.bind(this)) }
        );

        this.#shadow = this.attachShadow({ mode: 'closed' });
        this.#shadow.appendChild(content);
    }

    /**
      * @public
      * @param{String} info
      */
    setInfo(info) {
        this.#shadow.getElementById("info").textContent = info;
    }

    /**
      * @public
      * @param{String} header
      */
    setHeader(header) {
        this.#shadow.getElementById("header").textContent = header;
    }

    /**
      * @public
      * @param{Function} method
      */
    setUpdatehandler(method) {
        this.#callbacks.set(this.#callbackId, method);
        const prevId = this.#callbackId;
        ++this.#callbackId;
        return prevId;
    }

    deleteUpdatehandler(handlerId) {
        this.#callbacks.delete(handlerId);
    }

    #update(event) {
        event.preventDefault();
        this.#callbacks.forEach(method => { method(event.target.href) });
    }
}

customElements.define('page-component', Page);
