package rest

// API методы для общения c backend
class ServerAPI {
	private val client = Client()

	private fun url(str: String) :String {
		return "http://localhost:8080/api/$str"
	}

	//-------Users API--------------
	fun register (json: String, callback: (String)->Unit) {
		// POST /api/candidate/
		client.post(url("candidate/"), json, callback)
	}

	fun login(json: String, callback: (String)->Unit) {
		//POST /api/sessions/
		client.post(url("session/"), json, callback)
	}

	fun logout(callback: (String)->Unit) {
		// DELETE /api/sessions/
		client.delete(url("sessions/"), callback)
	}

	fun updateEducation(json: String, callback: (String)->Unit) {
		// PUT /api/candidate/education
		client.put(url("candidate/education"), json, callback)
	}

	fun getEducation(callback: (String)->Unit) {
		// GET /api/candidate/education
		client.fetch(url("candidate/education"), call = callback)
	}

	fun updateWorkExp(json: String, callback: (String)->Unit) {
		// PUT /api/candidate/workexp
		client.put(url("candidate/workexp"), json, callback)
	}

	fun getWorkExp(callback: (String)->Unit) {
		//GET /api/candidate/workexp
		client.fetch(url("candidate/workexp"), call = callback)
	}

	fun updateWillWork(json: String, callback: (String)->Unit) {
		// PUT /api/candidate/willwork
		client.put(url("candidate/willwork"), json, callback)
	}

	fun getWillWork(callback: (String)->Unit) {
		// GET /api/candidate/willwork
		client.fetch(url("candidate/willwork"), call = callback)
	}

	fun updateOther(json: String, callback: (String)->Unit) {
		// PUT /api/candidate/other
		client.put(url("candidate/other"), json, callback)
	}

	fun getOther(callback: (String)->Unit) {
		// GET /api/candidate/other
		client.fetch(url("candidate/other"), call = callback)
	}
	fun getPeronal(callback: (String)->Unit) {
		// GET /api/candidate/personal
		client.fetch(url("candidate/personal"), call = callback)
	}

}

//fun loadCathedrasList(url: String, call: (List<JsonCathedra>) -> Unit) {
//	client.fetch(url) { e ->
//		val embed = JSON.parse<Embedded<JsonCathedras>>(e)
//		val cathedras = embed._embedded?.cathedras?.toList() ?: ArrayList()
//		call(cathedras)
//	}
//}




















