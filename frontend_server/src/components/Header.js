import React from "react";
import { FaDownload } from "react-icons/fa";
import { MdCloudUpload } from "react-icons/md";
import axios from "axios";
import fileDownload from 'js-file-download'

class Header extends React.Component {
    render() {
        return (<header>
            <h2>{this.props.title}</h2>
            <div className="data">
                <h4>Сохранить / загрузить реестр</h4>
                <div className="file-icons">
                    <FaDownload className="download-icon" onClick={() => this.downloadFile()}/>
                    <MdCloudUpload className="upload-icon"/>
                </div>
            </div>
        </header>)
    }

    downloadFile() {
        axios.get(this.props.urlOfData, {
            responseType: 'blob',
        })
            .then((res) => {
                fileDownload(res.data, "weapons.xml")
            })
    }
}

export default Header;
