/*******************************************************************************
 * Copyright (c) 2016 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package cdi12.classexclusion.test;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Vetoed;

import cdi12.classexclusion.test.interfaces.IVetoedBean;

@RequestScoped
@Vetoed
public class VetoedBean implements IVetoedBean {

    @Override
    public String getOutput() {
        return "VetoedBean was incorrectly injected";
    }

}
