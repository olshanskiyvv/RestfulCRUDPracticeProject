import React from "react";
import {FaDownload} from "react-icons/fa";
import {MdCloudUpload} from "react-icons/md";
import axios from "axios";
import fileDownload from 'js-file-download'
import ImportForm from "./ImportForm";

class Header extends React.Component {
    constructor(props, context) {
        super(props, context);
        this.state = {
            showForm: false
        }

        this.uploadFile = this.uploadFile.bind(this)
    }


    render() {
        return (<header>
            <h2>{this.props.title}</h2>
            <div className="data">
                <h3>Сохранить / загрузить реестр</h3>
                <div className="file-icons">
                    <FaDownload className="download-icon" onClick={() => this.downloadFile()}/>
                    <MdCloudUpload className="upload-icon"
                                   onClick={() => this.setState({showForm: !this.state.showForm})}/>
                    {this.state.showForm && <ImportForm toDo={this.uploadFile}/>}
                </div>
            </div>
        </header>)
    }

    downloadFile() {
        axios.get(this.props.urlBase + "download", {responseType: 'blob',})
            .then((res) => {
                fileDownload(res.data, "weapons.xml")
            })
            .catch(error => console.log(error))
    }

    uploadFile(file) {
        this.setState({showForm: !this.state.showForm})
        const config =
            axios.post(this.props.urlBase + "upload",
                {file: file},
                {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .then(response => {
                    console.log("Экспорт файла\n" + response)
                    this.props.updateList()
                })
                .catch(error => console.log(error))
    }
}

export default Header;
