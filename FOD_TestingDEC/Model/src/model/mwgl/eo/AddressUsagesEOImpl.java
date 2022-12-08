package model.mwgl.eo;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Nov 29 23:16:26 IST 2022
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AddressUsagesEOImpl extends EntityImpl {

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        AddressUsagesId {
            public Object get(AddressUsagesEOImpl obj) {
                return obj.getAddressUsagesId();
            }

            public void put(AddressUsagesEOImpl obj, Object value) {
                obj.setAddressUsagesId((DBSequence)value);
            }
        }
        ,
        AssociatedOwnerId {
            public Object get(AddressUsagesEOImpl obj) {
                return obj.getAssociatedOwnerId();
            }

            public void put(AddressUsagesEOImpl obj, Object value) {
                obj.setAssociatedOwnerId((Number)value);
            }
        }
        ,
        OwnerTypeCode {
            public Object get(AddressUsagesEOImpl obj) {
                return obj.getOwnerTypeCode();
            }

            public void put(AddressUsagesEOImpl obj, Object value) {
                obj.setOwnerTypeCode((String)value);
            }
        }
        ,
        AddressId {
            public Object get(AddressUsagesEOImpl obj) {
                return obj.getAddressId();
            }

            public void put(AddressUsagesEOImpl obj, Object value) {
                obj.setAddressId((Number)value);
            }
        }
        ,
        UsageTypeCode {
            public Object get(AddressUsagesEOImpl obj) {
                return obj.getUsageTypeCode();
            }

            public void put(AddressUsagesEOImpl obj, Object value) {
                obj.setUsageTypeCode((String)value);
            }
        }
        ,
        ExpiredFlag {
            public Object get(AddressUsagesEOImpl obj) {
                return obj.getExpiredFlag();
            }

            public void put(AddressUsagesEOImpl obj, Object value) {
                obj.setExpiredFlag((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(AddressUsagesEOImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(AddressUsagesEOImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CreationDate {
            public Object get(AddressUsagesEOImpl obj) {
                return obj.getCreationDate();
            }

            public void put(AddressUsagesEOImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        LastUpdatedBy {
            public Object get(AddressUsagesEOImpl obj) {
                return obj.getLastUpdatedBy();
            }

            public void put(AddressUsagesEOImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        LastUpdateDate {
            public Object get(AddressUsagesEOImpl obj) {
                return obj.getLastUpdateDate();
            }

            public void put(AddressUsagesEOImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        ObjectVersionId {
            public Object get(AddressUsagesEOImpl obj) {
                return obj.getObjectVersionId();
            }

            public void put(AddressUsagesEOImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        PersonsEO {
            public Object get(AddressUsagesEOImpl obj) {
                return obj.getPersonsEO();
            }

            public void put(AddressUsagesEOImpl obj, Object value) {
                obj.setPersonsEO((PersonsEOImpl)value);
            }
        }
        ,
        AddressesEO {
            public Object get(AddressUsagesEOImpl obj) {
                return obj.getAddressesEO();
            }

            public void put(AddressUsagesEOImpl obj, Object value) {
                obj.setAddressesEO((AddressesEOImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(AddressUsagesEOImpl object);

        public abstract void put(AddressUsagesEOImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    private static AddressUsagesEODefImpl mDefinitionObject;

    public static final int ADDRESSUSAGESID = AttributesEnum.AddressUsagesId.index();
    public static final int ASSOCIATEDOWNERID = AttributesEnum.AssociatedOwnerId.index();
    public static final int OWNERTYPECODE = AttributesEnum.OwnerTypeCode.index();
    public static final int ADDRESSID = AttributesEnum.AddressId.index();
    public static final int USAGETYPECODE = AttributesEnum.UsageTypeCode.index();
    public static final int EXPIREDFLAG = AttributesEnum.ExpiredFlag.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDATE = AttributesEnum.LastUpdateDate.index();
    public static final int OBJECTVERSIONID = AttributesEnum.ObjectVersionId.index();
    public static final int PERSONSEO = AttributesEnum.PersonsEO.index();
    public static final int ADDRESSESEO = AttributesEnum.AddressesEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public AddressUsagesEOImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = (AddressUsagesEODefImpl)EntityDefImpl.findDefObject("model.mwgl.eo.AddressUsagesEO");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for AddressUsagesId, using the alias name AddressUsagesId.
     * @return the AddressUsagesId
     */
    public DBSequence getAddressUsagesId() {
        return (DBSequence)getAttributeInternal(ADDRESSUSAGESID);
    }

    /**
     * Sets <code>value</code> as the attribute value for AddressUsagesId.
     * @param value value to set the AddressUsagesId
     */
    public void setAddressUsagesId(DBSequence value) {
        setAttributeInternal(ADDRESSUSAGESID, value);
    }

    /**
     * Gets the attribute value for AssociatedOwnerId, using the alias name AssociatedOwnerId.
     * @return the AssociatedOwnerId
     */
    public Number getAssociatedOwnerId() {
        return (Number)getAttributeInternal(ASSOCIATEDOWNERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for AssociatedOwnerId.
     * @param value value to set the AssociatedOwnerId
     */
    public void setAssociatedOwnerId(Number value) {
        setAttributeInternal(ASSOCIATEDOWNERID, value);
    }

    /**
     * Gets the attribute value for OwnerTypeCode, using the alias name OwnerTypeCode.
     * @return the OwnerTypeCode
     */
    public String getOwnerTypeCode() {
        return (String)getAttributeInternal(OWNERTYPECODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for OwnerTypeCode.
     * @param value value to set the OwnerTypeCode
     */
    public void setOwnerTypeCode(String value) {
        setAttributeInternal(OWNERTYPECODE, value);
    }

    /**
     * Gets the attribute value for AddressId, using the alias name AddressId.
     * @return the AddressId
     */
    public Number getAddressId() {
        return (Number)getAttributeInternal(ADDRESSID);
    }

    /**
     * Sets <code>value</code> as the attribute value for AddressId.
     * @param value value to set the AddressId
     */
    public void setAddressId(Number value) {
        setAttributeInternal(ADDRESSID, value);
    }

    /**
     * Gets the attribute value for UsageTypeCode, using the alias name UsageTypeCode.
     * @return the UsageTypeCode
     */
    public String getUsageTypeCode() {
        return (String)getAttributeInternal(USAGETYPECODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for UsageTypeCode.
     * @param value value to set the UsageTypeCode
     */
    public void setUsageTypeCode(String value) {
        setAttributeInternal(USAGETYPECODE, value);
    }

    /**
     * Gets the attribute value for ExpiredFlag, using the alias name ExpiredFlag.
     * @return the ExpiredFlag
     */
    public String getExpiredFlag() {
        return (String)getAttributeInternal(EXPIREDFLAG);
    }

    /**
     * Sets <code>value</code> as the attribute value for ExpiredFlag.
     * @param value value to set the ExpiredFlag
     */
    public void setExpiredFlag(String value) {
        setAttributeInternal(EXPIREDFLAG, value);
    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the CreatedBy
     */
    public String getCreatedBy() {
        return (String)getAttributeInternal(CREATEDBY);
    }

    /**
     * Gets the attribute value for CreationDate, using the alias name CreationDate.
     * @return the CreationDate
     */
    public Date getCreationDate() {
        return (Date)getAttributeInternal(CREATIONDATE);
    }

    /**
     * Gets the attribute value for LastUpdatedBy, using the alias name LastUpdatedBy.
     * @return the LastUpdatedBy
     */
    public String getLastUpdatedBy() {
        return (String)getAttributeInternal(LASTUPDATEDBY);
    }

    /**
     * Gets the attribute value for LastUpdateDate, using the alias name LastUpdateDate.
     * @return the LastUpdateDate
     */
    public Date getLastUpdateDate() {
        return (Date)getAttributeInternal(LASTUPDATEDATE);
    }

    /**
     * Gets the attribute value for ObjectVersionId, using the alias name ObjectVersionId.
     * @return the ObjectVersionId
     */
    public Number getObjectVersionId() {
        return (Number)getAttributeInternal(OBJECTVERSIONID);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public PersonsEOImpl getPersonsEO() {
        return (PersonsEOImpl)getAttributeInternal(PERSONSEO);
    }
    public PersonsEOImpl getPerson() {
        return (PersonsEOImpl)getAttributeInternal(PERSONSEO);
    }
    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setPersonsEO(PersonsEOImpl value) {
        setAttributeInternal(PERSONSEO, value);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public AddressesEOImpl getAddressesEO() {
        return (AddressesEOImpl)getAttributeInternal(ADDRESSESEO);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setAddressesEO(AddressesEOImpl value) {
        setAttributeInternal(ADDRESSESEO, value);
    }


    /**
     * @param addressUsagesId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(DBSequence addressUsagesId) {
        return new Key(new Object[]{addressUsagesId});
    }

    public void postChanges(TransactionEvent transactionEvent) {
        /* If current entity is new or modified */
       if (getPostState() == STATUS_NEW || 
            getPostState() == STATUS_MODIFIED) {
            /* Get the associated Address for the Address Usage */
            AddressesEOImpl address = getAddressesEO();
            PersonsEOImpl person = this.getPerson();

            /* If there is an associated product */
            if (address != null) {
                /* And if it's post-status is NEW */
                byte addressPostState = address.getPostState();                
                if (addressPostState == STATUS_NEW) {
                    /*
                     * Post the Address first, before posting this
                     * entity by calling super below
                     */
                    address.postChanges(transactionEvent);
                }
            }
            if (person != null) {
                if (person.getPostState() == STATUS_NEW){
                    /*
                    * Post the person first, before posting this
                    * entity by calling super below
                    */
                    person.postChanges(transactionEvent);
                }
            }
        }
        super.postChanges(transactionEvent);
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    public void create(AttributeList attributeList) {
        super.create(attributeList);
    }

    /**
     * Add entity remove logic in this method.
     */
    public void remove() {
        super.remove();
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        super.doDML(operation, e);
    }
}