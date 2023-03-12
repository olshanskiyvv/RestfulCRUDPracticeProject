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
      <Header title="Реестр огнестрельного оружия" />
      <main>
        <Weapons onEdit={this.updateData} onDelete={this.deleteData} weapons={this.state.weapons} />
      </main>
      <aside>
        <WeaponForm toDo={this.addData} weapon={null} buttonText="Добавить"/>
      </aside>
    </div>)
  }

  updateData(id, data) {
    axios.put(baseUrl + "weapons/" + id, data)
        .then(response => console.log("Изменение\n" + response))
        .catch(error => console.log(error))

    setTimeout(() => {this.getAllData()}, 100)
  }

  deleteData(id) {
    axios.delete(baseUrl + "weapons/" + id)
        .then(response => console.log("Удаление\n" + response))
        .catch(error => console.log(error))

    setTimeout(() => {this.getAllData()}, 100)
  }

  getAllData() {
    axios.get(baseUrl)
        .then((request) => {
          console.log("Загрузка данных")
          this.setState({weapons: request.data})
        })
        .catch(error => console.log(error))
  }

  addData(data) {
    console.log(data)

    axios.post(baseUrl, data)
        .then(response => console.log("Добавление\n" + response))
        .catch(error => console.log(error))

    setTimeout(() => {this.getAllData()}, 100)
  }

}

export default App;
