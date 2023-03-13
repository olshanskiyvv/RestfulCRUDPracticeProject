import React from "react";
import Header from "./components/Header";
import Weapons from "./components/Weapons";
import WeaponForm from "./components/WeaponForm";
import axios from "axios";

const baseUrl = "http://localhost:8080/"

class App extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      isUpdated: true,
      weapons: []
    }

    this.addData = this.addData.bind(this)
    this.getAllData = this.getAllData.bind(this)
    this.deleteData = this.deleteData.bind(this)
    this.updateData = this.updateData.bind(this)

    this.getAllData()
  }

  render() {
    return (<div>
      <Header title="Реестр огнестрельного оружия" urlOfData={baseUrl + "download"} />
      <main>
        <Weapons onEdit={this.updateData} onDelete={this.deleteData} weapons={this.state.weapons} />
      </main>
      <aside>
        <h3>Добавить новую запись</h3>
        <WeaponForm toDo={this.addData} weapon={null} buttonText="Добавить"/>
      </aside>
    </div>)
  }

  updateData(id, data) {
    axios.put(baseUrl + "weapons/" + id, data)
        .then(response => {
          console.log("Изменение\n" + response)
          this.getAllData()
        })
        .catch(error => console.log(error))
  }

  deleteData(id) {
    axios.delete(baseUrl + "weapons/" + id)
        .then(response => {
          console.log("Удаление\n" + response)
          this.getAllData()
        })
        .catch(error => console.log(error))
  }

  getAllData() {
    axios.get(baseUrl)
        .then((request) => {
          console.log("Загрузка данных")
          this.setState({weapons: []}, () => {this.setState({weapons: request.data})})
        })
        .catch(error => {
          this.setState({weapons: []}, () => console.log("Данных нет"))
          console.log("Ошибка: " + error)
        })
  }

  addData(data) {
    console.log(data)

    axios.post(baseUrl, data)
        .then(response => {
          console.log("Добавление\n" + response)
          this.getAllData()
        })
        .catch(error => console.log(error))
  }

}

export default App;
