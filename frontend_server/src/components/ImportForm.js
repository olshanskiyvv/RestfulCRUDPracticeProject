import React from "react";

class ImportForm extends React.Component {
    constructor(props, context) {
        super(props, context);
        this.state = {
            file: null
        }
    }
    render() {
        return (<form ref={(el) => this.myForm = el}>
            <input type="file" className="file" onChange={(value) => this.setState({file: value.target.files[0]})}/>
            <button type="button" onClick={() => {
                console.log(this.state.file)
                this.props.toDo(this.state.file)
                this.myForm.reset()
            }}>Импорт</button>
        </form>)
    }
}

export default ImportForm;
