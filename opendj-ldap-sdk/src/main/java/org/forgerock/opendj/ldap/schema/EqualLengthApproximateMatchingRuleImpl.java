/*
 * CDDL HEADER START
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License, Version 1.0 only
 * (the "License").  You may not use this file except in compliance
 * with the License.
 *
 * You can obtain a copy of the license at legal-notices/CDDLv1_0.txt
 * or http://forgerock.org/license/CDDLv1.0.html.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL HEADER in each
 * file and include the License file at legal-notices/CDDLv1_0.txt.
 * If applicable, add the following below this CDDL HEADER, with the
 * fields enclosed by brackets "[]" replaced with your own identifying
 * information:
 *      Portions Copyright [yyyy] [name of copyright owner]
 *
 * CDDL HEADER END
 *
 *
 *      Copyright 2009 Sun Microsystems, Inc.
 */
package org.forgerock.opendj.ldap.schema;

import org.forgerock.opendj.ldap.Assertion;
import org.forgerock.opendj.ldap.ByteSequence;
import org.forgerock.opendj.ldap.ByteString;
import org.forgerock.opendj.ldap.ConditionResult;
import org.forgerock.opendj.ldap.DecodeException;

/**
 * This class implements an extremely simple approximate matching rule that will
 * consider two values approximately equal only if they have the same length. It
 * is intended purely for testing purposes.
 */
final class EqualLengthApproximateMatchingRuleImpl extends AbstractMatchingRuleImpl {
    @Override
    public Assertion getAssertion(final Schema schema, final ByteSequence value)
            throws DecodeException {
        return new Assertion() {
            public ConditionResult matches(final ByteSequence attributeValue) {
                return attributeValue.length() == value.length() ? ConditionResult.TRUE
                        : ConditionResult.FALSE;
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    public ByteString normalizeAttributeValue(final Schema schema, final ByteSequence value) {
        return value.toByteString();
    }
}
