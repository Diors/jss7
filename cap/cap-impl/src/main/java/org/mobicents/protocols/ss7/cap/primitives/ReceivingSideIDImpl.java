/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.protocols.ss7.cap.primitives;

import java.io.IOException;

import org.mobicents.protocols.asn.AsnException;
import org.mobicents.protocols.asn.AsnInputStream;
import org.mobicents.protocols.asn.AsnOutputStream;
import org.mobicents.protocols.asn.Tag;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.CAPParsingComponentException;
import org.mobicents.protocols.ss7.cap.api.CAPParsingComponentExceptionReason;
import org.mobicents.protocols.ss7.cap.api.primitives.ReceivingSideID;
import org.mobicents.protocols.ss7.inap.api.primitives.LegType;
import org.mobicents.protocols.ss7.map.api.MAPParsingComponentException;

/**
 * 
 * @author sergey vetyutnev
 * 
 */
public class ReceivingSideIDImpl implements ReceivingSideID, CAPAsnPrimitive {

	public static final int _ID_receivingSideID = 1;

	public static final String _PrimitiveName = "ReceivingSideID";

	private LegType receivingSideID;

	
	
	@Override
	public LegType getReceivingSideID() {
		return receivingSideID;
	}
	
	@Override
	public int getTag() throws CAPException {
		return _ID_receivingSideID;
	}

	@Override
	public int getTagClass() {
		return Tag.CLASS_CONTEXT_SPECIFIC;
	}

	@Override
	public boolean getIsPrimitive() {
		return true;
	}

	@Override
	public void decodeAll(AsnInputStream ansIS) throws CAPParsingComponentException {

		try {
			int length = ansIS.readLength();
			this._decode(ansIS, length);
		} catch (IOException e) {
			throw new CAPParsingComponentException("IOException when decoding " + _PrimitiveName + ": " + e.getMessage(), e,
					CAPParsingComponentExceptionReason.MistypedParameter);
		} catch (AsnException e) {
			throw new CAPParsingComponentException("AsnException when decoding " + _PrimitiveName + ": " + e.getMessage(), e,
					CAPParsingComponentExceptionReason.MistypedParameter);
		} catch (MAPParsingComponentException e) {
			throw new CAPParsingComponentException("MAPParsingComponentException when decoding " + _PrimitiveName + ": " + e.getMessage(), e,
					CAPParsingComponentExceptionReason.MistypedParameter);
		}
	}

	@Override
	public void decodeData(AsnInputStream ansIS, int length) throws CAPParsingComponentException {

		try {
			this._decode(ansIS, length);
		} catch (IOException e) {
			throw new CAPParsingComponentException("IOException when decoding " + _PrimitiveName + ": " + e.getMessage(), e,
					CAPParsingComponentExceptionReason.MistypedParameter);
		} catch (AsnException e) {
			throw new CAPParsingComponentException("AsnException when decoding " + _PrimitiveName + ": " + e.getMessage(), e,
					CAPParsingComponentExceptionReason.MistypedParameter);
		} catch (MAPParsingComponentException e) {
			throw new CAPParsingComponentException("MAPParsingComponentException when decoding " + _PrimitiveName + ": " + e.getMessage(), e,
					CAPParsingComponentExceptionReason.MistypedParameter);
		}
	}

	private void _decode(AsnInputStream ansIS, int length) throws CAPParsingComponentException, MAPParsingComponentException, IOException, AsnException {

		this.receivingSideID = null;
		
		if (ansIS.getTag() != _ID_receivingSideID || ansIS.getTagClass() != Tag.CLASS_CONTEXT_SPECIFIC || !ansIS.isTagPrimitive())
			throw new CAPParsingComponentException("Error while decoding " + _PrimitiveName
					+ ": choice receivingSideID has bad tag or tagClass or is not primitive", CAPParsingComponentExceptionReason.MistypedParameter);

		int i1 = (int)ansIS.readIntegerData(length); 
		this.receivingSideID = LegType.getInstance(i1);
		if (this.receivingSideID == null)
			throw new CAPParsingComponentException("Error while decoding " + _PrimitiveName + ": bad LegType parameter",
					CAPParsingComponentExceptionReason.MistypedParameter);
	}

	@Override
	public void encodeAll(AsnOutputStream asnOs) throws CAPException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void encodeAll(AsnOutputStream asnOs, int tagClass, int tag) throws CAPException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void encodeData(AsnOutputStream asnOs) throws CAPException {
		// TODO Auto-generated method stub
		
	}

}
