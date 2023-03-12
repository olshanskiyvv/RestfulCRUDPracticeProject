import React from "react";

class WeaponForm extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
              type: null,
              name: null,
              capacity: null,
              weight: null,
              sightingRange: null,
              rateOfFire: null,
        }

        if (this.props.weapon !== null)
            this.state = {
                type: this.props.weapon.type,
                name: this.props.weapon.name,
                capacity: this.props.weapon.capacity,
                weight: this.props.weapon.weight,
                sightingRange: this.props.weapon.sightingRange,
                rateOfFire: this.props.weapon.rateOfFire,
            }
    }

    render() {
        return (
            <form ref={(el) => {this.myForm = el}}>
                <input placeholder="Наименование оружия"
                       onChange={value => this.setState({name: value.target.value})}
                       defaultValue={this.state.name}/>
                <input placeholder="Тип оружия"
                       onChange={value => this.setState({type: value.target.value})}
                       defaultValue={this.state.type}/>
                <input placeholder="Емкость магазина"
                       onChange={value => this.setState({capacity: value.target.value})}
                       defaultValue={this.state.capacity}/>
                <input placeholder="Вес"
                       onChange={value => this.setState({weight: value.target.value})}
                       defaultValue={this.state.weight}/>
                <input placeholder="Дальность причельносй стрельбы (м)"
                       onChange={value => this.setState({sightingRange: value.target.value})}
                       defaultValue={this.state.sightingRange}/>
                <input placeholder="Скорострельность (выстр/мин)"
                       onChange={value => this.setState({rateOfFire: value.target.value})}
                       defaultValue={this.state.rateOfFire}/>
                <button type="button" onClick={() => {
                    this.myForm.reset()
                    if (this.props.weapon === null)
                        this.props.toDo(this.state)
                    else
                        this.props.toDo(this.props.weapon.serialNumber, this.state)
                    this.setState({
                        type: null,
                        name: null,
                        capacity: null,
                        weight: null,
                        sightingRange: null,
                        rateOfFire: null,
                    })
                }}>{this.props.buttonText}</button>
            </form>
        )
    }
}

export default WeaponForm;
