/*******************************************************************************************
 *	Copyright (c) 2016, zzg.zhou(11039850@qq.com)
 * 
 *  Monalisa is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU Lesser General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.

 *	This program is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU Lesser General Public License for more details.

 *	You should have received a copy of the GNU Lesser General Public License
 *	along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************************/
package com.tsc9526.monalisa.tools.converters.impl;

import com.tsc9526.monalisa.tools.converters.Conversion;

/**
 * 
 * @author zzg.zhou(11039850@qq.com)
 */
public class ByteTypeConversion implements Conversion<Byte> {
 
	public Object[] getTypeKeys() {
		return new Object[] {
			Byte.class,
			Byte.TYPE,
			Byte.class.getName(),
			TYPE_BYTE
		};
	}

	 
	public Byte convert(Object value, Class<?> type) {
		if (value == null){
			return null;
		}

		if(value.getClass()==boolean.class || value.getClass()==Boolean.class){
			return ((Boolean)value)?(byte)1:(byte)0;
		}
		
		if (!(value instanceof Byte)) {
			String v=value.toString();
			if (v.trim().length()==0) {
				value=null;
			}
			else {
				value=Byte.parseByte(v);
			}
		}
		return (Byte)value;
	}
}
