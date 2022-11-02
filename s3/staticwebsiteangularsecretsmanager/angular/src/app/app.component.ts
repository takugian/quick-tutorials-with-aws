import { Component } from '@angular/core';

import { SecretsManagerClient, GetSecretValueCommand } from "@aws-sdk/client-secrets-manager";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'staticwebsiteangularsecretsmanager';

  credentials = { accessKeyId: "", secretAccessKey: "", secretId: "" };

  constructor() { }

  ngOnInit(): void {
  }

  loadSecretsManager(): void {

    if (!this.credentials.accessKeyId) {
      alert('accessKeyId is required')
    }

    if (!this.credentials.secretAccessKey) {
      alert('secretAccessKey is required')
    }

    if (!this.credentials.secretId) {
      alert('secretId is required')
    }

    const client = new SecretsManagerClient({ region: "us-east-2", credentials: this.credentials });

    const command = new GetSecretValueCommand({ SecretId: this.credentials.secretId });

    client.send(command).then(
      (data) => {
        alert(data);

      },
      (error) => {
        alert(error);
      }
    );

  }

}
