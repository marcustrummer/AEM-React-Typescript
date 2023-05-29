/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2020 Adobe Systems Incorporated
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

import { ModelManager } from '@adobe/aem-spa-page-model-manager';
import React from 'react';
import ReactDOM from 'react-dom';
import sinon from 'sinon';
import extractModelId from '../../utils/extract-model-id';
import { WelcomeHome } from './WelcomeHome';

describe('Welcomehome ->', () => {
  const CONTENT_PATH = '/content/test/cq/path';
  const COMPONENT_TITLE_EXPECTED = 'Bem vindo a Valtech_';

  let rootNode: ReactDOM.Container | null;

  let sandbox = sinon.createSandbox();

  beforeEach(() => {
    sandbox
      .stub(ModelManager, 'getData')
      .withArgs({ pagePath: CONTENT_PATH })
      .resolves({ test: true });

    rootNode = document.createElement('div');
    document.body.appendChild(rootNode);

    ModelManager.initialize();
  });

  afterEach(() => {
    window.location.hash = '';

    if (rootNode) {
      document.body.removeChild(rootNode);
    }

    sandbox.restore();
  });

  it('should render the WelcomeHome component that contains the provided text as a string', () => {
    expect(rootNode.childElementCount).toEqual(0);
    ReactDOM.render(<WelcomeHome title={COMPONENT_TITLE_EXPECTED} />, rootNode);

    expect(rootNode.childElementCount).toEqual(1);

    expect(rootNode.firstChild.innerHTML).toContain(COMPONENT_TITLE_EXPECTED);
  });


});
