package rest

import org.w3c.xhr.XMLHttpRequest

class Client {
    var xhttp= XMLHttpRequest();

    fun fetch(url:String, header: String ="application/hal+json",
              call: (String) -> Unit) {
        xhttp.open("GET", url, true);
        xhttp.setRequestHeader("Accept", header)
        xhttp.onload = {
            call(xhttp.responseText)
        }
        xhttp.send();
    }

	fun getMethod(url:String, content: String, header: String ="application/hal+json", call: (String) -> Unit) {
        xhttp.open("GET", url, true);
        xhttp.setRequestHeader("Accept", header)
        xhttp.onload = {
            call(xhttp.responseText)
        }
        xhttp.send(content);
    }
	
    fun post(url:String, content:String, call: (String) -> Unit = {}) {
        xhttp.open("POST", url, true);
        xhttp.setRequestHeader("Content-Type", "application/hal+json")
        xhttp.onload = {
            call(xhttp.responseText)
        }
        xhttp.send(content)
    }

    fun delete(url:String, call: (String) -> Unit = {}){
        xhttp.open("DELETE", url, true);
        xhttp.setRequestHeader("Content-Type", "application/hal+json")
        xhttp.onload = {
            call(xhttp.responseText)
        }
        xhttp.send();
    }

    fun put(url:String, content:String, call: (String) -> Unit = {}){
        xhttp.open("PUT", url, true);
        xhttp.setRequestHeader("Content-Type", "application/hal+json")
        xhttp.onload = {
            call(xhttp.responseText)
        }
        xhttp.send(content);
    }
}

