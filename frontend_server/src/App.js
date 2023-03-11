import React from "react";
import Header from "./components/Header";
import Weapons from "./components/Weapons";
import WeaponForm from "./components/WeaponForm";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      weapons: [
          {
            serialNumber: 1,
            type: "gun",
            name: "ak-47",
            capacity: 50,
            weight: 250.0,
            sightingRange: null,
            rateOfFire: null,
          },
          {
            serialNumber: 2,
            type: "gun",
            name: "ak-74",
            capacity: 50,
            weight: 250.0,
            sightingRange: null,
            rateOfFire: null,
          },
          {
            serialNumber: 3,
            type: "gun",
            name: "m16",
            capacity: 50,
            weight: 250.0,
            sightingRange: null,
            rateOfFire: null,
          },
      ]
    }
  }

  render() {
    return (<div>
      <Header title="Реестр огнестрельного оружия" />
      <main>
        <Weapons weapons={this.state.weapons} />
      </main>
      <aside>
        <WeaponForm buttonText="Добавить"/>
      </aside>
    </div>)
  }
}

export default App;
