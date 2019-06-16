package rest

// API методы для общения c backend
class ServerAPI {
	private val client = Client()

	private fun url(str: String) :String {
		return "http://localhost:8080/$str"
	}

	//-------Users API--------------



	//------Companies API-----------


}

// Example
// 1 Для таблицы лекторов
// загрузка списка доступных кафедр
// http://localhost:8080/cathedras
//fun loadCathedrasList(url: String, call: (List<JsonCathedra>) -> Unit) {
//	client.fetch(url) { e ->
//		val embed = JSON.parse<Embedded<JsonCathedras>>(e)
//		val cathedras = embed._embedded?.cathedras?.toList() ?: ArrayList()
//		call(cathedras)
//	}
//}




















