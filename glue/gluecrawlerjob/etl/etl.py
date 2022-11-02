import sys
from awsglue.transforms import *
from awsglue.utils import getResolvedOptions
from pyspark.context import SparkContext
from awsglue.context import GlueContext
from awsglue.job import Job

args = getResolvedOptions(sys.argv, ["JOB_NAME"])
sc = SparkContext()
glueContext = GlueContext(sc)
spark = glueContext.spark_session
job = Job(glueContext)
job.init(args["JOB_NAME"], args)

# Script generated for node AWS Glue Data  Customers
AWSGlueDataCustomers_node1659540852745 = glueContext.create_dynamic_frame.from_catalog(
    database="databasetestglue",
    table_name="customers_csv",
    transformation_ctx="AWSGlueDataCustomers_node1659540852745",
)

# Script generated for node AWS Glue Data Catalog Accounts
AWSGlueDataCatalogAccounts_node1659540865743 = (
    glueContext.create_dynamic_frame.from_catalog(
        database="databasetestglue",
        table_name="accounts_csv",
        transformation_ctx="AWSGlueDataCatalogAccounts_node1659540865743",
    )
)

# Script generated for node Drop Fields
DropFields_node1659540881938 = DropFields.apply(
    frame=AWSGlueDataCustomers_node1659540852745,
    paths=["document_number", "age"],
    transformation_ctx="DropFields_node1659540881938",
)

# Script generated for node Drop Fields
DropFields_node1659540890323 = DropFields.apply(
    frame=AWSGlueDataCatalogAccounts_node1659540865743,
    paths=["account_id"],
    transformation_ctx="DropFields_node1659540890323",
)

# Script generated for node Rename Field
RenameField_node1659540902186 = RenameField.apply(
    frame=DropFields_node1659540881938,
    old_name="name",
    new_name="customer_name",
    transformation_ctx="RenameField_node1659540902186",
)

# Script generated for node Rename Field
RenameField_node1659540920875 = RenameField.apply(
    frame=DropFields_node1659540890323,
    old_name="bank",
    new_name="bank_name",
    transformation_ctx="RenameField_node1659540920875",
)

# Script generated for node Join
Join_node1659540950538 = Join.apply(
    frame1=RenameField_node1659540902186,
    frame2=RenameField_node1659540920875,
    keys1=["customer_id"],
    keys2=["customer_id"],
    transformation_ctx="Join_node1659540950538",
)

# Script generated for node Drop Fields
DropFields_node1659540994293 = DropFields.apply(
    frame=Join_node1659540950538,
    paths=["customer_id", "`.customer_id`"],
    transformation_ctx="DropFields_node1659540994293",
)

# Script generated for node Amazon S3
AmazonS3_node1659541007392 = glueContext.write_dynamic_frame.from_options(
    frame=DropFields_node1659540994293,
    connection_type="s3",
    format="csv",
    connection_options={
        "path": "s3://tg-quicklabs-testglue/job3/",
        "partitionKeys": [],
    },
    transformation_ctx="AmazonS3_node1659541007392",
)

job.commit()